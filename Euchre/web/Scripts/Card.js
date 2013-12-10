var Suit = {Clubs : 0, Spades : 1, Hearts : 2, Diamonds : 3}
var Rank = {Two : 0, Three: 1, Four: 2, Five: 3, Six: 4, Seven: 5, Eight: 6, Nine: 7, Ten: 8, Jack : 9, Queen : 10, King : 11, Ace : 12}

function Card(suit_, rank_)
{
	this.suit = suit_;
	this.rank = rank_;
	this.imageSource = "PlayingCards/" + this.getRankAbbreviated() + this.getSuitAbbreviated() + ".png";
}

function Card(rankOrder)
{
	this.suit = Math.floor(rankOrder / 13);
	this.rank = rankOrder % 13;
	//get the filename of the image
	this.imageSource = "PlayingCards/" + this.getRankAbbreviated() + this.getSuitAbbreviated() + ".png";
}

Card.prototype.getSuit = function()
{
	switch(this.suit)
	{
	case 0:
		return "Clubs";
	break;
	case 1:
		return "Spades";
	break;
	case 2:
		return "Hearts";
	break;
	case 3:
		return "Diamonds";
	break;
	}
}

Card.prototype.getSuitAbbreviated = function()
{
	switch(this.suit)
	{
	case 0:
		return "c";
	break;
	case 1:
		return "s";
	break;
	case 2:
		return "h";
	break;
	case 3:
		return "d";
	break;
	}
}

Card.prototype.getRank = function()
{
	if(this.rank < 9)
	{
		return (this.rank + 2).toString();
	}
	else
	{
		switch(this.rank)
		{
			case 9:
				return "Jack";
			break;
			case 10:
				return "Queen";
			break;
			case 11:
				return "King";
			break;
			case 12:
				return "Ace";
			break;
		}
	}
}

Card.prototype.getRankAbbreviated = function()
{
	if(this.rank < 9)
	{
		return (this.rank + 2).toString();
	}
	else
	{
		switch(this.rank)
		{
			case 9:
				return "j";
			break;
			case 10:
				return "q";
			break;
			case 11:
				return "k";
			break;
			case 12:
				return "a";
			break;
		}
	}
}

Card.prototype.description = function()
{
	return this.getRank() + " of " + this.getSuit();
}

Card.prototype.sortOrder = function()
{
	return this.rank + 13 * this.suit;
}

Card.prototype.draw = function(x, y, id)
{
	var cardsElement = document.getElementById(id);
	var img = document.createElement("img");
	img.id = id;
	img.src = this.imageSource;
	img.width = 71;
	img.height = 96;
	img.alt = this.description();
	img.style.position = "absolute";
	img.style.top = y + "px";
	img.style.left = x + "px";
	cardsElement.appendChild(img);
}