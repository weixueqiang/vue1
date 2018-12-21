
function formatDate(row, column, cellValue, index) {
  let date = new Date(cellValue);
  return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDay()+" "+date.getHours()+":"+date.getMinutes();
}

export default formatDate;
