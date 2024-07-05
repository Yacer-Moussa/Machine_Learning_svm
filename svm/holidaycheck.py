import svm
import vector as vec
import io_utils as io

def label_to_num(label: str) -> int:
    if label == "__label__negative":
        return -1
    
    if label == "__label__positive":
        return 1
    
    return None

def num_to_label(label: int) -> str:
    if label < 0:
        return "__label__negative"
    
    if label > 0:
        return "__label__positive"
    
    return None

def load_data(file_path: str) -> dict[str, svm.Observation]:
    data = {}

    raw_file = io.read_csv(file_path = file_path, delimiter = ",")
    
    for line in raw_file[1:]:
        label = label_to_num(line[1])
        if label is None:
            continue

        id = line[0]
        vector = vec.Vector(list(map(int, line[2:])))

        obs = svm.Observation(vector = vector, label = label)

        data[id] = obs

    return data

def write_data(file_path: str, data: dict[str, svm.Observation], header: list[str]) -> None:
    res = []
    
    if header is not None:
        res.append(header)

    for key in data:
        line = []

        label = num_to_label(data[key].label)
        vector = list(map(str, data[key].vector.value))

        line.append(key)
        line.append(label)
        line += vector

        res.append(line)

    io.write_csv(file_path = file_path, delimiter = ",", data = res)

def train_svm():
    '''Train svm'''

    data = load_data("reduced_train_data_no_neutral.csv")
    observations = []

    for key in data:
        observations.append(data[key])

    #create svm instance
    my_svm = svm.SVM(learning_rate = 0.001, iterations = 3000)

    #train svm
    my_svm.fit(training_data = observations)

    #save model to file
    my_svm.save_model("svm/resources/model.json")

def inference_svm():
    '''Inference svm'''

    #create svm instance
    my_svm = svm.SVM()

    #load model from file
    my_svm.load_model("svm/resources/model.json")

    data_orig = load_data("reduced_test_data_no_neutral.csv")
    data_pred = {}

    for key in data_orig:
        #create deep copy of current observation without label
        obs = svm.Observation(vector = data_orig[key].vector, label = None)

        #predict label
        my_svm.predict(obs)

        data_pred[key] = obs

    #evaluate results
    classified_wrong = 0
    classified_right = 0

    for key in data_orig:
        obs_orig = data_orig[key]
        obs_pred = data_pred[key]

        if obs_orig.label == obs_pred.label:
            classified_right += 1
        else:
            classified_wrong += 1

    print(f"Classified right: {round((classified_right / (classified_right + classified_wrong)) * 100, 2)}%")

    #write results to file
    header = io.read_csv("reduced_test_data_no_neutral.csv", ",")
    header = header[0]

    write_data("svm/resources/prediction_results.csv", data_pred, header = header)

def main():
    train_svm()
    inference_svm()

if __name__ == "__main__":
    main()
