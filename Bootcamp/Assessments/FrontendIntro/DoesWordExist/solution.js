function doesWordExist(wordsArr, word) {
    if (wordsArr.length == 0 || word.length == 0) {
      return false;
    }
    for (let i = 0; i < wordsArr.length; i++) {
      if (word == wordsArr[i]) {
        return true;
      }
    }
    return false;
  }