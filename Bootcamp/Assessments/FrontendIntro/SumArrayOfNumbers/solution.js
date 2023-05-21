let result = 0;
function sumArray(numbers) {
  if (numbers.length == 0)
    return 0;
  for (let i = 0; i < numbers.length; i++) {
    result += numbers[i];
  }
  return result;
}