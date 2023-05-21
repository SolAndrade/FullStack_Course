const chai = require("chai")
const assert = chai.assert
chai.config.truncateThreshold = 0

describe('product(x,y)', () => {
  it('should multiply two numbers correctly',  () => {
    assert.equal(product(2, 2), 4);
  });
});