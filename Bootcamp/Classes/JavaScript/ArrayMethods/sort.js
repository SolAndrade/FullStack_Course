// We will be demoing on the array of words:

const words = ["Hello", "great", "First", "A", "a", "how"];

// Sorting strings ascending:

// Now, let's make a copy of the array and apply the simple sort. This method applied without compare function will sort strings in ascending order.

// Note: The capitalized letters will come before lowercase ones.

const wordsAsc = words.slice().sort();

console.log(`words asc: ${wordsAsc}`); // words asc: A,First,Hello,a,great,how

console.log(`original words: ${words}`); // original words: Hello,great,First,A,a,how

// To surpass this limitation, we should apply .toLowercase() on all words and then compare them:

const properWordsSort = words.slice().sort((a, b) => {
  a = a.toLowerCase();
  b = b.toLowerCase();
  if (a === b) return 0;
  return a > b ? 1 : -1;
});

console.log(properWordsSort);
// [ 'A', 'a', 'First', 'great', 'Hello', 'Hello', 'how' ]

// Sorting strings descending:

// When in need to sort strings in descending order, we need to pass the following compare function (still working with the words array):

const wordsDesc = words.slice().sort((a, b) => {
  if (a > b) {
    return -1;
  }
  if (a < b) {
    return 1;
  }
  return 0;
});

console.log(`words desc: ${wordsDesc}`); // words desc: how,great,a,Hello,First,A
console.log(`original words: ${words}`); // original words: Hello,great,First,A,a,how

// Sorting by length:

const sortedByLength = words.slice().sort((a, b) => {
  if (a.length > b.length) return 1;
  if (a.length < b.length) return -1;
  if (a.length === b.length) return 0;
});


console.log("---> ", sortedByLength);
// --->  ['A', 'a', 'how',   'Hello', 'Hello', 'great', 'First' ]

// Sorting by more than one condition:

const arr = [
  { title: "Carrot", votes: 3 },
  { title: "Milk", votes: 2 },
  { title: "Banana", votes: 2 },
  { title: "Apple", votes: 1 },
];

const byVotesAlphabetically = arr.slice().sort((a, b) => {
  if (a.votes > b.votes) return -1;
  if (a.votes < b.votes) return 1;
  if (a.title > b.title) return 1;
  if (a.title < b.title) return -1;
});
console.log(byVotesAlphabetically);

// [
//   { title: 'Carrot', votes: 3 },
//   { title: 'Banana', votes: 2 },
//   { title: 'Milk', votes: 2 },
//   { title: 'Apple', votes: 1 }
// ]
