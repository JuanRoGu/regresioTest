function resultObj()
{

//Attributes declaration
    this.nombre;
    this.json;
    //Constructor
    this.construct = function (nombre,json)
    {
        this.setNombre(nombre);
        this.setJson(json);
    };
    
 // getters && Setters
    
    
    this.setNombre = function (nombre){this.nombre = nombre;};
    this.setJson = function (json){this.json = json;};
    
    this.getNombre = function () {return this.nombre;};
    this.getJson = function () {return this.json;};
    
       
}