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
    this.mensajeDestino;
    this.fechaAlta;
    this.fechaDesde
    this.fechaHasta
    this.seleccionado;
    
    
  //Constructor
    this.construct = function (idPeticion, instrumento,origen,destino,fechaDesde,fechaHasta)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setFechaDesde(fechaDesde);
        this.setFechaHasta(fechaHasta);
        this.seleccionado = false;
       

    };  
    
    
    this.construct = function (idPeticion, instrumento,origen,destino)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setOrigen(origen);
        this.setDestino(destino);

        this.seleccionado = false;
    };
    
    this.construct = function (idPeticion, instrumento,origen,accion)
    {
        this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setOrigen(origen);
        this.setDestino(accion);

        this.seleccionado = false;
    };

    this.construct = function (idPeticion, instrumento,accion,origen,destino,mensaje,mensajeNeutro,mensajeDestino)
    {
    	this.setIdPeticion(idPeticion);
        this.setInstrumento(instrumento);
        this.setOrigen(origen);
        this.setAccion(accion);
        this.setDestino(destino);
        this.setMensaje(mensaje);
        this.setMensajeNeutro(mensajeNeutro);
        this.setMensajeDestino(mensajeDestino);
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
    this.setFechaAlta = function (fechaAlta){this.fechaAlta = fechaAlta;};
    this.setFechaHasta = function (fechaHasta){this.fechaHasta = fechaHasta;};
    this.setMensajeNeutro = function (mensajeNeutro){this.mensajeNeutro = mensajeNeutro;};
    this.setMensajeDestino = function (mensajeDestino){this.mensajeDestino = mensajeDestino;};
    this.setSeleccionado = function (seleccionado){this.seleccionado = seleccionado;};
    
    
    this.getIdPeticion = function () {return this.idPeticion;};
    this.getInstrumento = function () {return this.instrumento;};
    this.getAccion = function () {return this.accion;};
    this.getOrigen = function () {return this.origen;};
    this.getDestino = function () {return this.destino;};
    this.getMensaje = function () {return this.mensaje;};
    this.getFechaDesde = function () {return this.fechaDesde;};
    this.getFechaHasta = function () {return this.fechaHasta;};
    this.getFechaAlta = function () {return this.fechaAlta;};
    this.getMensaje = function () {return this.mensaje;};
    this.getMensajeNeutro = function () {return this.mensajeNeutro;};
    this.getMensajeDestino = function () {return this.mensajeDestino;};
    this.getSeleccionado = function () {return this.Seleccionado;};
    
    //Methods
    
    this.toString = function ()
    {
    	
    	var peticionString = "";

        peticionString += "IdPeticion: " + this.getIdPeticion() + " Instrumento: " + this.getInstrumento + " Accion: " + this.getAccion() + " Origen: " + this.getOrigen() +  " Destino: " + this.getDestino() +
        " Mensaje: " + this.getMensaje() + "FechaDesde" + this.getFechaDesde() + " FechaHasta: " +this.getFechaHasta()+ "mensaje: "+this.getMensaje()+"mensajeNeutro: "+this.getMensajeNeutro()+"\n";
        
        
        return peticionString;
    }
    
    

}