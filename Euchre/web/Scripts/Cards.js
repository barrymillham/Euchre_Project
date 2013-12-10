var DeckType = {Player : 0, Deck : 1, Computer : 2, DiscardPile : 3};

function Cards(x_, y_, deckType_)
{
	this.cards = new Array();
	this.x = x_;
	this.y = y_;
	this.cardWidth = 71;
	this.cardHeight = 96;
	this.deckType = deckType_;

	//back of card
	this.backCard = new Card(Suit.c, Rank.Two);
	this.backCard.imageSource = "PlayingCards/back.png";
}

//takes a suit and returns the index of the first card of that suit, or
//-1 if the suit is not in the deck
Cards.prototype.firstSuitIndex = function(suit)
{
	for(var i = 0; i < this.cards.length; ++i)
	{
		if(this.cards[i].suit == suit)
			return i;
	}

	return -1;
}

//sees if the deck has an eight and returns the index if it does,
//or -1 otherwise
Cards.prototype.hasEight = function()
{
	for(var i = 0; i < this.cards.length; ++i)
	{
		if(this.cards[i].getRank() == 8)
			return i;
	}

	return -1;
}

//returns the card at the index
Cards.prototype.cardAt = function(index)
{
	return this.cards[index];
}

//finds the index of a given card
Cards.prototype.findCard = function(card)
{
	for(var i = 0; i < this.cards.length; ++i)
	{
		if(this.cards[i] == card)
		{
			return i;
		}
	}

	return -1;
}
//sorts the cards
Cards.prototype.sortHand = function()
{
	//insertion sort lolz
	for(var i = 1; i < this.cards.length; ++i)
	{
		var insertValue = this.cards[i].sortOrder();
		var tempValue = this.cards[i];
		var hole = i;
		while(hole > 0 && insertValue < this.cards[hole-1].sortOrder())
		{
			this.cards[hole] = this.cards[hole-1];
			hole--;
		}
		this.cards[hole] = tempValue;
	}
}
//shuffles the cards
Cards.prototype.shuffle = function()
{
	for(var i = this.cards.length-1; i > 0; --i)
	{
		var index = Math.floor(Math.random()*(i+1));
		var temp = this.cards[index];
		this.cards[index] = this.cards[i];
		this.cards[i] = temp;
	}
}

Cards.prototype.addCardAtRear = function(card)
{
	this.cards.push(card);
}

Cards.prototype.addCardAtFront = function(card)
{
	this.cards.unshift(card);
}

Cards.prototype.removeTopCard = function()
{
	return this.cards.shift();
}

Cards.prototype.removeBottomCard = function()
{
	return this.cards.pop();
}

Cards.prototype.removeCard = function(suit, rank)
{
	for(var i = 0; i < this.cards.length; ++i)
	{
		if(this.cards[i].suit == suit && this.cards[i].rank == rank)
		{
			return this.cards.splice(i, 1)[0];
		}
	}

	return null;
}

Cards.prototype.removeCardAtIndex = function(index)
{
	if(index < this.cards.length && index >= 0)
	{
		return this.cards.splice(index, 1)[0];
	}
	else
	{
		return null;
	}
}

//draws the deck according to the specified type
Cards.prototype.draw = function()
{
	if(this.deckType == DeckType.Player)
	{
		var cardsElement = document.getElementById("player");
		cardsElement.innerHTML = "";
		for(var i = 0; i < this.cards.length; ++i)
		{
			this.cards[i].draw(this.x + i * this.cardWidth, this.y, "player");
		}
	}
	else if(this.deckType == DeckType.Deck)
	{
		var cardsElement = document.getElementById("deck");
		cardsElement.innerHTML = "";
		this.backCard.draw(this.x, this.y, "deck");
	}
	else if(this.deckType == DeckType.Computer)
	{
		var cardsElement = document.getElementById("computer");
		cardsElement.innerHTML = "";
		for(var i = 0; i < this.cards.length; ++i)
		{
			this.backCard.draw(this.x + i * this.cardWidth, this.y, "computer");
		}
	}
	else if(this.deckType == DeckType.DiscardPile)
	{
		var cardsElement = document.getElementById("drawpile");
		cardsElement.innerHTML = "";
		if(this.cards.length > 0)
		{
			this.cards[0].draw(this.x + this.cardWidth, this.y, "drawpile");
		}
	}
}
//draws a specific card
Cards.prototype.drawCardAtIndex = function(index, xCoordinate, yCoordinate, id)
{
	this.cards[index].draw(xCoordinate, yCoordinate, id);
}