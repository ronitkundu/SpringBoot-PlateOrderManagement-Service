class checking{
	 constructor(name, year) {
    this.name = name;
    this.year = year;
}
}
	
let myCar1 = new checking("Ford", 2014);

document.getElementById("demo").innerHTML=myCar1.name+"   "+myCar1.year;

function func1(){
	
	document.getElementById("firstfield").value=myCar1.name+"   "+myCar1.year;
}