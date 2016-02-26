function peticionObj()
{
	  //Attributes declaration
    this.idPeticion;
    this.instrumento;
    this.accion;
    this.origen;
    this.destino;
    this.mensaje;
    this.mensajeNeutro;
    this.fechaDesde
    this.fechaHasta
    this.seleccionado;
    
    
  //Constructor
    this.construct = function (idPeticion, instrumento,accion,origen,mensaje,mensajeNeutro)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setAccion(accion);
        this.setOrigen(origen);
        this.setMensaje(mensaje);
        this.setMensaje(mensajeNeutro);
        this.seleccionado = false;
       

    };
    
    this.construct = function (idPeticion, instrumento,accion,origen)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setAccion(accion);
        this.setOrigen(origen);
        this.seleccionado = false;
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
    this.setFechaHasta = function (fechaHasta){this.fechaHasta = fechaHasta;};
    this.setMensaje = function (mensajeNeutro){this.mensajeNeutro = mensajeNeutro;};
    this.setSeleccionado = function (seleccionado){this.seleccionado = seleccionado;};
    
    
    this.getIdPeticion = function () {return this.idPeticion;};
    this.getInstrumento = function () {return this.instrumento;};
    this.getAccion = function () {return this.accion;};
    this.getOrigen = function () {return this.origen;};
    this.getDestino = function () {return this.destino;};
    this.getMensaje = function () {return this.mensaje;};
    this.getFechaDesde = function () {return this.fechaDesde;};
    this.getFechaHasta = function () {return this.fechaHasta;};
    this.getMensaje = function () {return this.mensaje;};
    this.getMensajeNeutro = function () {return this.mensajeNeutro;};
    this.getSeleccionado = function () {return this.Seleccionado;};
    
    //Methods
    
    this.toString = function ()
    {
    	
    	var peticionString = "";

        peticionString += "IdPeticion: " + this.getIdPeticion() + " Instrumento: " + this.getInstrumento + " Accion: " + this.getAccion() + " Origen: " + this.getOrigen() +
        " Mensaje: " + this.getMensaje() + "FechaDesde" + this.getFechaDesde() + " FechaHasta: " +this.getFechaHasta()+ "mensaje: "+this.getMensaje()+"mensajeNeutro: "+this.getMensajeNeutro()+"\n";
        
        
        return peticionString;
    }
    
    

}