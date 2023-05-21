function maxOfThreeNumbers(a, b, c) {
    if(a < b && a < c){
      if(b < c) {
        return c;
      } else {
        return b;
      }
    } else if (b < a && b < c) {
      if (a < c) {
        return c;
      } else {
        return a;
      }
    } else {
      if (a < b) {
        return b;
      } else {
        return a;
      }
    }
  }