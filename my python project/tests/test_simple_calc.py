import pytest
from app.simple_calc import SimpleCalc

@pytest.fixture
def calc():
    # Arrange
    return SimpleCalc()

@pytest.mark.parametrized
@pytest.mark.calculation
@pytest.mark.parametrize(
    "a, b, expected",
    [
        (1, 1, 2),
        (-1, 2, 1),
        (2.5, 0.5, 3.0)
    ]
)
def test_add_parametrized(calc, a, b, expected):
    # Act
    result = calc.add(a, b)
    # Assert
    assert result == expected

@pytest.mark.calculation
def test_subtract(calc):
    # Act
    result = calc.subtract(5, 3)
    # Assert
    assert result == 2

@pytest.mark.calculation
def test_multiply(calc):
    # Act
    result = calc.multiply(3, 4)
    # Assert
    assert result == 12

@pytest.mark.calculation
def test_divide(calc):
    # Act
    result = calc.divide(10, 2)
    # Assert
    assert result == 5

@pytest.mark.exceptions
def test_divide_by_zero(calc):
    # Act & Assert
    with pytest.raises(ZeroDivisionError):
        calc.divide(5, 0)

@pytest.mark.calculation
def test_power(calc):
    # Act
    result = calc.power(2, 3)
    # Assert
    assert result == 8

@pytest.mark.exceptions
def test_invalid_input(calc):
    # Act & Assert
    with pytest.raises(TypeError):
        calc.add("a", 5)

@pytest.mark.validation
def test_negative_numbers(calc):
    # Act
    result = calc.add(-2, -3)
    # Assert
    assert result == -5