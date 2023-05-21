const chai = require("chai")
const assert = chai.assert
chai.config.truncateThreshold = 0

describe('findUnique(wordsArr)', () => {
  it('should return the unique string that occurs first in the array', () => {
    const result = findUnique(['foo', 'bar', 'foo', 'baz', 'bar', 'fizz', 'foo']);
    assert.equal(result, 'baz');
  });

  it('should return false if the argument is an empty array', () => {
    const result = findUnique([]);
    assert.equal(result, false);
  });
});