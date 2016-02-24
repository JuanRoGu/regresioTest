function peticionObj()
{
	  //Attributes declaration
    this.idPeticion;
    this.instrumento;
    this.accion;
    this.origen;
    this.destino;
    this.mensaje;
    this.fechaDesde
    this.fechaHasta
    
    
  //Constructor
    this.construct = function (idPeticion, instrumento,accion,origen,destino,mensaje,fechaDesde,fechaHasta)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setAccion(accion);
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setMensaje(mensaje);
        this.setFechaDesde(fechaDesde);
        this.setFechaHasta(fechaHasta);

    };
    
    this.construct = function (idPeticion, instrumento,accion,origen,destino)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setAccion(accion);
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setMensaje(mensaje);
    };
    // getters && Setters
    
    
    this.setIdPeticion = function (idPeticion){this.idPeticion = idPeticion;};
    this.setInstrumento = function (instrumento){this.instrumento = instrumento;};
    this.setAccion = function (accion){this.accion = accion;};
    this.setOrigen = function (origen){this.origen = origen;};
    this.setDestino = function (destino){this.destino = destino;};
    this.setMensaje = function (mensaje){this.mensaje = mensaje;};
    this.setFechaDesde = function (fechaDesde){this.fechaDesde = fechaDesde;};
    this.setFechaHasta = function (fechaHasta){this.fechaHasta = fechaHasta;};
    
    this.getIdPeticion = function () {return this.idPeticion;};
    this.getInstrumento = function () {return this.instrumento;};
    this.getAccion = function () {return this.accion;};
    this.getOrigen = function () {return this.origen;};
    this.getDestino = function () {return this.destino;};
    this.getMensaje = function () {return this.mensaje;};
    this.getFechaDesde = function () {return this.fechaDesde;};
    this.getFechaHasta = function () {return this.fechaHasta;};
    
    //Methods
    
    this.toString = function ()
    {
    	
    	var peticionString = "";

        peticionString += "IdPeticion: " + this.getPeticionId() + " Instrumento: " + this.getInstrumento + " Accion: " + this.getAccion() + " Origen: " + this.getOrigen() +
        " Destino: " +this.getDestino() + " Mensaje: " + this.getMensaje() + "FechaDesde" + this.getFechaDesde() + " FechaHasta: " +this.getFechaHasta()+"\n";
        return clientString;
    }
    
    

}