const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;

describe('sumArray(numbers)', () => {
  it('should return the sum of all numbers in the array.', () => {
    assert.equal( sumArray( [1, 2, 3, 4] ), 10);
  });

  it('should return 0 when first argument is an empty array.', () => {
    assert.equal( sumArray( [] ), 0);
  });
});
  