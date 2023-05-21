let max;
function maxOfArray(numbers) {
  if (numbers.length == 0) {
    return false;
  }
  max = numbers[0];
  for (let i = 1; i < numbers.length; i++) {
    if (max < numbers[i]) {
      max = numbers[i];
    }
  }
  return max;
}