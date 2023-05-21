function findUnique(wordsArr) {
    if (wordsArr.length == 0) {
      return false;
    }
    const frequency = {};
    for (let word of wordsArr) {
      frequency[word] = (frequency[word] || 0) + 1;
    }
    for (let word of wordsArr) {
      if (frequency[word] === 1) {
        return word;
      }
    }
    return null;
  }