import pytest

@pytest.mark.usefixtures("setup")
class BasedClass:
    pass

class Testexample:
    def test_exectuting(self):
        print("I am executing")