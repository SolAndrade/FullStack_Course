const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;

describe('longestString(stringsArr)', () => {
  it('should return the longest string from the given array.', () => {
    assert.equal( longestString( ['ted', 'ed', 'teddy'] ), 'teddy');
  });

  it('should return the first found longest string in the given array.', () => {
    assert.equal( longestString( ['abc', 'bca', 'bac', 'bbb'] ), 'abc');
  });
});