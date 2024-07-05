import numpy as np
import svm
import vector as vec
import matplotlib.pyplot as plt

def main():
    vectors_train = [[1.6,0.3], [1.8,0.5], [2.0,0.7], [2.2,0.4], [2.4,0.6], [2.3,0.5], [2.1,0.5],
              [1.7,1.7], [2.5,1.0], [1.0,3.0], [2.0,1.5], [1.5,1.5], [1.5,2.0], [1.0,2.5],
              [1.6,1.6], [2.4,0.9], [0.9,2.9], [1.9,1.4], [1.0,1.4], [1.4,1.9], [0.9,2.4],
              [1.5,1.7], [2.3,1.1], [0.4,1.0], [1.0,0.7], [1.2,1.5], [1.2,1.0], [1.0,1.1],
              [1.0,1.7], [1.3,1.1], [0.7,1.0], [0.4,0.7], [0.2,1.5], [0.2,1.0], [0.4,1.1],
              [1.0,0.5], [1.3,0.1], [0.7,0.3], [0.4,0.4], [0.2,0.5], [0.2,0.1], [0.4,0.1],
              [1.0,2.4], [1.3,2.1], [0.7,2.0], [0.4,2.7], [0.2,2.5], [0.2,2.0], [0.4,2.1],
              [3.4,2.0], [3.5,2.1], [3.6,2.3], [3.4,2.4], [3.5,2.5], [3.1,2.6], [3.3,2.7],
              [2.0,3.1], [3.5,1.0], [4.0,1.5], [3.0,3.0], [3.0,2.0], [2.5,2.5], [3.3,1.5],
              [3.9,2.5], [3.9,2.0], [3.8,3.0], [3.8,2.9], [3.9,2.7], [3.9,2.5], [3.9,2.7],
              [2.1,3.1], [3.6,1.1], [3.8,1.7], [3.2,3.1], [2.9,2.1], [2.6,2.4], [3.2,1.4],
              [4.0,0.1], [3.9,0.2], [3.9,0.3], [3.7,0.5], [3.9,0.7], [3.9,0.4], [3.7,0.4]]
    
    vector_labels = [-1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1,
              -1, -1, -1, -1, -1, -1, -1,
              1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1,
              1, 1, 1, 1, 1, 1, 1]
    
    observations_train = []

    for v, y in zip(vectors_train, vector_labels):
        vector = vec.Vector(value=v)

        observations_train.append(svm.Observation(vector=vector, label=y))

    for obs in observations_train:
        if obs.label == -1:
            plt.scatter(obs.vector.value[0], obs.vector.value[1], s=120, marker="_", linewidths=2)
        else:
            plt.scatter(obs.vector.value[0], obs.vector.value[1], s=120, marker="+", linewidths=2)

    #create svm instance
    my_svm = svm.SVM(learning_rate = 0.001, iterations = 20000)

    #train svm
    my_svm.fit(training_data = observations_train)

   #plt.scatter(my_svm.weight.value[0], my_svm.weight.value[1], s=120, marker="*", linewidths=2)

    x_points = np.linspace(1,4)

    y_points = -(my_svm.weight.value[0] / my_svm.weight.value[1]) * x_points - my_svm.bias / my_svm.weight.value[1]

    plt.plot(x_points, y_points, c='r')

    plt.show()


main()