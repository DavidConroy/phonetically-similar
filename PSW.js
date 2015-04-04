require('./cmudict.js');
require('./freq_list.js');
require('./nouns2.js');

cmudictLC = {};
for (key in cmudict) {
  cmudictLC[key.toLowerCase()] = cmudict[key];
}


requiredPhoneme = "AH1";

function output(p, n) {
  var output = [];
  for (key in cmudictLC) {
    if (cmudictLC[key].indexOf(p) !== -1 && typeof freqList[key] !== 'undefined') {
      output.push([key, freqList[key]]);
    }
  }

  sortedOutput = output.sort(function(x,y) {
    return y[1] - x[1]
  });

  var nounFiltered = output.filter(function(x){
    return (typeof nouns[x[0]] !== 'undefined');
  });

  if (typeof n !== 'undefined') {
    return nounFiltered.slice(0,n);
  } else {
    return nounFiltered
  }
};
