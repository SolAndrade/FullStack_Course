const chai = require("chai")
const assert = chai.assert
chai.config.truncateThreshold = 0

describe('maxOfThreeNumbers(a, b, c)', () => {
  it('should return the first argument when the first argument is the highest number', () => {
    assert.equal(maxOfThreeNumbers(99, 50, 3), 99);
  });

  it('should return the second argument when the second argument is the highest number', () => {
    assert.equal(maxOfThreeNumbers(10, 82, 3), 82);
  });

  it('should return the third argument when the third argument is the highest number', () => {
    assert.equal(maxOfThreeNumbers(4, 5, 6), 6);
  });

  it('should return the value closest to 0 when all arguments are numbers that are less than 0.', () => {
   assert.equal(maxOfThreeNumbers(-4, -5, -19), -4);
  });
});