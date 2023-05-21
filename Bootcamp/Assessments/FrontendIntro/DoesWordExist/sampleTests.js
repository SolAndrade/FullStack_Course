const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;

describe('doesWordExist(wordsArr, word)', () => {
  it('should return true if the given array contains the expected string', () => {
    assert.equal(doesWordExist(['foo', 'bar', 'baz'], 'foo'), true);
  });

  it("should return false if the given array doesn't contain the expected string", () => {
    assert.equal(doesWordExist(['foo', 'bar', 'baz'], 'fizz'), false);
  });
});