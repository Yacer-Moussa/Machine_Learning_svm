from __future__ import annotations
import math

class Vector:
    def __init__(self, value: list[float]) -> None:
        self.value = value

    def __str__(self) -> str:
        return ','.join(str(x) for x in self.value)
    
    def add(self, v: Vector) -> Vector:
        '''Add vector v and return result'''

        if len(self.value) != len(v.value):
            raise Exception("Number of dimensions is different")

        tmp = []

        for x, y in zip(self.value, v.value):
            tmp.append(x + y)

        return Vector(value = tmp)

    def sub(self, v: Vector) -> Vector:
        '''Substract vector v and return result'''

        if len(self.value) != len(v.value):
            raise Exception("Number of dimensions is different")

        tmp = []

        for x, y in zip(self.value, v.value):
            tmp.append(x - y)

        return Vector(value = tmp)

    def mul(self, x: float) -> Vector:
        '''Multiply (scale) vector with x and return result'''
        
        tmp = []

        for entry in self.value:
            tmp.append(entry * x)

        return Vector(value = tmp)

    def dot(self, v: Vector) -> float:
        '''Calculate dot product with vector v and return result'''

        if len(self.value) != len(v.value):
            raise Exception("Number of dimensions is different")

        dot_prod = 0

        for x, y in zip(self.value, v.value):
            dot_prod = dot_prod + (x * y)

        return dot_prod

    def dist(self, v: Vector) -> float:
        '''Calculate the distance to vector v and return result'''

        if len(self.value) != len(v.value):
            raise Exception("Number of dimensions is different")
        
        dist = 0

        for x, y in zip(self.value, v.value):
            dist = dist + (x - y) * (x - y)

        return math.sqrt(dist)

    def mag(self) -> float:
        '''Calculate the magnitude (length) of the vector and return result'''
        mag = 0

        for entry in self.value:
            mag = mag + (entry * entry)

        return math.sqrt(mag)

    def norm(self) -> Vector:
        '''Calculate the normalized vector (magnitude = 1) and return result'''
        
        mag = self.mag()

        if mag == 0:
            return self
        
        tmp = []

        for entry in self.value:
            tmp.append(entry / mag)

        return Vector(value = tmp)

    def ndim(self) -> int:
        '''Return number of dimensions'''
        return len(self.value)
