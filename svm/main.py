import svm
import vector as vec

def read_csv(file_path: str, delimiter: str) -> list[svm.Observation]:
    '''Read observation data from csv with the following format:
       x1;x2;...;xn;label
       label can be "krank" or "gesund"'''

    #read from file
    raw_data = []
    with open(file=file_path, mode='r') as file:
        #skip first line
        file.readline()

        for line in file:
            raw_data.append(line.rstrip().split(delimiter))

    #convert to observation
    res = []
    for observation in raw_data:
        vector = list(map(int, observation[0:-1]))

        #assign classes 1 and -1
        sentiment = None
        if observation[-1] == "krank":
            sentiment = 1
        if observation[-1] == "gesund":
            sentiment = -1

        res.append(svm.Observation(vector = vec.Vector(value = vector), label = sentiment))
    
    return res

def pred_to_label(pred: svm.Observation) -> str:
    '''Helper to map label to prediction'''

    if pred.label is None:
        return "None"

    if pred.label >= 0:
        return "krank"
    
    return "gesund"

def train_svm():
    '''Train svm'''

    #load data
    observations = read_csv(file_path="trainingsdatentagged.csv", delimiter=";")

    #create svm instance
    my_svm = svm.SVM(learning_rate = 0.001, iterations = 3000)

    #train svm
    my_svm.fit(training_data = observations)

    #save model to file
    my_svm.save_model("model.json")

def inference_svm():
    '''Inference svm'''

    #create svm instance
    my_svm = svm.SVM()

    #load model from file
    my_svm.load_model("model.json")

    #define some test samples
    obs_1 = svm.Observation(vector = vec.Vector([1,0,0,1,1,0,0,1,1,0,1]), label = None)
    obs_2 = svm.Observation(vector = vec.Vector([1,1,0,0,1,0,1,0,0,1,0]), label = None)
    obs_3 = svm.Observation(vector = vec.Vector([1,0,0,0,0,0,0,0,0,0,0]), label = None)

    #make prediction
    my_svm.predict(obs_1)
    my_svm.predict(obs_2)
    my_svm.predict(obs_3)

    #print samples after prediction
    print(f"Predicted Label obs_1: {pred_to_label(obs_1)}")
    print(f"Predicted Label obs_2: {pred_to_label(obs_2)}")
    print(f"Predicted Label obs_3: {pred_to_label(obs_3)}")

def main():
    #train_svm()
    inference_svm()

if __name__ == "__main__":
    main()
