import collections
from random import choice
Card = collections.namedtuple('Card',['rank','suit'])
suit_values =dict(spades = 3,hearts = 2,diamonds = 1,clubs = 0)
class FrenchDeck:
	ranks = [str(n) for n in range(2,11)] + list('JQKA')
	suits = 'spades diamonds clubs hearts'.split()

	def __init__(self):
		self.__cards = [Card(rank,suit) for suit in self.suits for rank in self.ranks]

	def __len__(self):
		return len(self.__cards)

	def __getitem__(self,position):
		return self.__cards[position]
def spades_high(card):
	rank_value = FrenchDeck.ranks.index(card.rank)
	return rank_value * len(suit_values) + suit_values[card.suit]
if __name__ == '__main__':
	beer_card = Card('7','diamonds')
	print(beer_card)
	deck = FrenchDeck()
	print(len(deck))
	print(deck[0])
	print(deck[-1])
	print(choice(deck))
	print(choice(deck))
	print(choice(deck))
	print(deck[:3])
	print(deck[12::13])#deck[12:13]是获取deck[12]，而deck[12::13]是先抽出deck[12]，然后每隔13取一个
	for card in deck: #正向遍历
		print(card)
	print("*"*100)
	for card in reversed(deck):#反向迭代遍历
		print(card)
	print("*"*100)
	print(Card('Q','hearts') in deck)
	print(Card('7','beasts') in deck)
	print("*"*100)
	for card in sorted(deck,key=spades_high):
		print(card)

