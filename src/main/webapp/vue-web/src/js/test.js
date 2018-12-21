


export default {
  formatDate(row, column, cellValue, index) {
    let date = new Date(cellValue);
    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDay()+" "+date.getHours()+":"+date.getMinutes();
  },
  errmsg(obj,msgdata){
    console.log(msgdata);
    obj.$message({
      showClose: true,
      message: msgdata,
      type: 'error',
      duration:3000
    });
  }

};
