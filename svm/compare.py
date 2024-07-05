import io_utils as io

predictions = io.read_csv("/home/maurice/Downloads/results.csv", ",")
expectations = io.read_csv("reduced_testdaten.csv", ",")

predictions_dict = {}
for pred in predictions[1:]:
    predictions_dict[pred[0]] = pred[1]

expectations_dict = {}
for expec in expectations[1:]:
    expectations_dict[expec[0]] = expec[1]


classified_wrong = 0
classified_right = 0
for key in predictions_dict:
    expected_label = expectations_dict[key]
    predicted_label = predictions_dict[key]

    if expected_label == "__label__neutral":
        continue

    if expected_label == predicted_label:
        classified_right += 1
    else:
        classified_wrong += 1

print(f"Classified right: {round((classified_right / (classified_right + classified_wrong)) * 100, 2)}%")
