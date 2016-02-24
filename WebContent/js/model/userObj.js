function UserObj ()
{
	//Attributes declaration
	
	this.user;
	this.pass;
	this.profile;


	//Methods declaration
	this.construct = function (user,pass,profile){
		this.setUser(user);
		this.setPass(pass);
		this.setProfile(profile);
	}

	this.setUser = function (user){this.user=user;}
	this.setPass = function (nick){this.pass=pass;}
	this.setProfile = function (profile){this.profile=profile;}

	this.getUser = function () {return this.user;}
	this.getPass = function () {return this.pass;}
	this.getProfile = function () {return this.profile;}
	
}