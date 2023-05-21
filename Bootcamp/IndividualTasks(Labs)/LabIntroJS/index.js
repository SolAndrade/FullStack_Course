 // The `movies` array from the file `./data.js`.
 const movies = require('./data.js');
 // console.log('movies: ', movies);
 
 
 // Iteration 1: All directors? - Get the array of all directors.
 // _Bonus_: It seems some of the directors had directed multiple movies so they will pop up multiple times in the array of directors.
 // How could you "clean" a bit this array and make it unified (without duplicates)?
 function getAllDirectors(movies) {
    const directorsSet = new Set();
  
    movies.forEach(movie => {
      directorsSet.add(movie.director);
    });
  
    return Array.from(directorsSet);
}
// Usage:
// console.log('All directors:', getAllDirectors(movies));
 
 // Iteration 2: Steven Spielberg. The best? - How many drama movies did STEVEN SPIELBERG direct?
 function howManyMovies(movies) {
    return movies.filter(movie => movie.director === 'Steven Spielberg' && movie.genre.includes('Drama')).length;
}
// Usage:
//console.log('Number of drama movies directed by Steven Spielberg:', howManyMovies(movies));
  
 // Iteration 3: All scores average - Get the average of all scores with 2 decimals
 function scoresAverage(movies) {
    if (movies.length === 0) {
      return 0;
    }
  
    const sumScores = movies.reduce((total, movie) => {
      if (movie.score) {
        return total + movie.score;
      } else {
        return total;
      }
    }, 0);
  
    const average = sumScores / movies.length;
    return parseFloat(average.toFixed(2));
  }
// Usage:
// console.log('Average score of all movies:', scoresAverage(movies));

 // Iteration 4: Drama movies - Get the average of Drama Movies
 function dramaMoviesScore(movies) {
    const dramaMovies = movies.filter(movie => movie.genre.includes('Drama'));
  
    if (dramaMovies.length === 0) {
      return 0;
    }
  
    const sumScores = dramaMovies.reduce((total, movie) => {
      if (movie.score) {
        return total + movie.score;
      } else {
        return total;
      }
    }, 0);
  
    const average = sumScores / dramaMovies.length;
    return parseFloat(average.toFixed(2));
  }
// Usage:
// console.log('Average score of drama movies:', dramaMoviesScore(movies));
 
 // Iteration 5: Ordering by year - Order by year, ascending (in growing order)
 function orderByYear(movies) {
    const sortedMovies = [...movies];
  
    sortedMovies.sort((a, b) => {
      if (a.year === b.year) {
        return a.title.localeCompare(b.title);
      } else {
        return a.year - b.year;
      }
    });
  
    return sortedMovies;
  }
  // Usage:
  //console.log('Movies sorted by year:', orderByYear(movies));
 
 // Iteration 6: Alphabetic Order - Order by title and print the first 20 titles
 function orderAlphabetically(movies) {
    const sortedMovies = [...movies];
  
    sortedMovies.sort((a, b) => a.title.localeCompare(b.title));
  
    const titles = sortedMovies.map(movie => movie.title);
  
    return titles.slice(0, 20);
  }
  // Usage:
  // console.log('First 20 titles in alphabetical order:', orderAlphabetically(movies));
 
 // BONUS - Iteration 7: Time Format - Turn duration of the movies from hours to minutes
 function turnHoursToMinutes(movies) {
    const modifiedMovies = movies.map(movie => {
      const duration = movie.duration;
      let minutes = 0;
  
      if (duration.includes('h') && duration.includes('min')) {
        const hours = parseInt(duration.split('h')[0]);
        const mins = parseInt(duration.split(' ')[1].split('min')[0]);
        minutes = hours * 60 + mins;
      } else if (duration.includes('h')) {
        minutes = parseInt(duration.split('h')[0]) * 60;
      } else if (duration.includes('min')) {
        minutes = parseInt(duration.split('min')[0]);
      }
  
      return { ...movie, duration: minutes };
    });
  
    return modifiedMovies;
  }
// Usage:
// console.log('Movies with duration in minutes:', turnHoursToMinutes(movies));

 // BONUS - Iteration 8: Best yearly score average - Best yearly score average
 function bestYearAvg(movies) {
    if (movies.length === 0) {
      return 'There are no movies in the array.';
    }
  
    const scoresByYear = {};
  
    movies.forEach(movie => {
      const year = movie.year;
      const score = movie.score;
  
      if (scoresByYear[year]) {
        scoresByYear[year].totalScore += score;
        scoresByYear[year].movieCount++;
      } else {
        scoresByYear[year] = {
          totalScore: score,
          movieCount: 1
        };
      }
    });
  
    let bestYear = null;
    let bestAverage = -1;
  
    for (const year in scoresByYear) {
      const average = scoresByYear[year].totalScore / scoresByYear[year].movieCount;
  
      if (average > bestAverage) {
        bestYear = year;
        bestAverage = average;
      }
    }
  
    return `The best year was ${bestYear} with an average score of ${bestAverage.toFixed(2)}`;
  }
// Usage:
//console.log(bestYearAvg(movies));
  