import json
import vector as vec
import os

class Observation:
    def __init__(self, vector: vec.Vector, label: int) -> None:
        self.vector = vector
        self.label = label

class SVM:
    def __init__(self, learning_rate: float = None, iterations: int = None, bias: float = None, weight: vec.Vector = vec.Vector(value = None)) -> None:
        self.learning_rate = learning_rate
        self.iterations = iterations
        self.bias = bias
        self.weight = weight

    def fit(self, training_data: list[Observation]) -> None:
        '''Train SVM by finding weight and bias'''

        #init weight and bias
        self.weight.value = [0] * training_data[0].vector.ndim()
        self.bias = 0

        for iteration in range(self.iterations):
            values_changed = False

            for sample in training_data:
                if sample.label * (self.weight.dot(sample.vector) + self.bias) >= 1:
                    #sample classified correct -> increase margin by decreasing length of weight vector
                    #self.weight = self.weight.sub(self.weight.mul(self.learning_rate))
                    print(f"{iteration}: sample classified correctly -> nothing todo")
                else:
                    #sample classified wrong or inside margin -> adjust weight vector and bias
                    self.weight = self.weight.add(sample.vector.mul(sample.label * self.learning_rate))
                    self.bias = self.bias + sample.label * self.learning_rate
                    print(f"{iteration}: sample classification condition violation -> adjust weight and bias")

                    if not values_changed:
                        values_changed = True

            print("")

            if not values_changed:
                print("Values have not changed in last iteration -> training finished")
                return

        print("Exit training...")

    def predict(self, sample: Observation) -> None:
        '''Predict label of observation sample'''

        if self.weight.dot(sample.vector) + self.bias >= 0:
            sample.label = 1
            return
        
        sample.label = -1

    def save_model(self, file_path: str):
        '''Save current model to file'''

        #delete old file
        if os.path.exists(path = file_path):
            os.remove(path = file_path)

        #write json to file
        with open(file = file_path, mode = 'w') as file:
            file.write(json.dumps(obj = self, default = lambda o : o.__dict__, indent = 4, sort_keys = True))

        print("Wrote model to file!")

    def load_model(self, file_path: str):
        '''Load model from file'''
        
        with open(file = file_path, mode = 'r') as file:
            svm_model = json.loads(file.read())
            
            self.learning_rate = svm_model["learning_rate"]
            self.iterations = svm_model["iterations"]
            self.bias = svm_model["bias"]
            self.weight.value = svm_model["weight"]["value"]

        print("Model loaded from file!")
