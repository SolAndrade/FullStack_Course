const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;

describe('maxOfTwoNumbers(a, b)', () => {
  it('should return a greater number from 2 provided numbers', () => {
    assert.equal( maxOfTwoNumbers(10, 99), 99);
  });

  it('should return a number closer to 0 when both numbers passed as arguments are lower than 0', () => {
    assert.equal( maxOfTwoNumbers(-4, -27), -4);
  });
});
  