const chai = require("chai")
const assert = chai.assert
chai.config.truncateThreshold = 0

describe("getFullName(  {  firstName: 'string',  lastName: 'string'  }  )", () => {
   it('should return a string', () => {
    assert.typeOf(getFullName({ firstName: 'Tony', lastName: 'Stark' }), 'string');
  });
  
  it('should return a string containing the firstName and the lastName', () => {
    assert.equal(getFullName({ firstName: 'Tony', lastName: 'Stark' }), 'Tony Stark');
  });
  
});