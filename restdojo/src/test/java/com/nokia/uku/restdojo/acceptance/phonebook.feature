Feature: Phonebook
	It should be possible to add entries to the Phonebook and search them by name or phone number.
	The search should use regular expressions. So searching for "Istvan" should find "Kiss Istvan", "Nagy Istvan", "Kovacs Istvanka", etc...
	Search results should be ordered by name.
	Phonebook should be a web application and provice REST API. Base URL of the REST API should be /rest/phonebook

Background:
	Given then Phonebook contains following entries:
		| name	      | phoneNumber  |
		| Nagy Istvan | +36202345678 |
		| Kiss Istvan | +36201234567 |
		| Gipsz Jakab | +36203456789 |
	
Scenario: Add entry to the Phonebook
	Given Phonebook is empty
	When the user adding entries to the Phonebook:
		| name	      | phoneNumber  |
		| Nagy Istvan | +36202345678 |
		| Kiss Istvan | +36201234567 |
		| Gipsz Jakab | +36203456789 |
	Then the Phonebook should contain 3 entries
	
Scenario: Search the Phonebook by name
	When user searches for name: "Istvan"
	Then the result should be:
		| name	      | phoneNumber  |
		| Kiss Istvan | +36201234567 |
		| Nagy Istvan | +36202345678 |

Scenario: Search the Phonebook by phone number
	When user searches for phone number: "789"
	Then the results should be:
		| name	      | phoneNumber  |
		| Gipsz Jakab | +36203456789 |

Scenario: Search all entries in the Phonebook
	When user searches for name: ""
	Then the result should be
		| name	      | phoneNumber  |
		| Gipsz Jakab | +36203456789 |
		| Kiss Istvan | +36201234567 |
		| Nagy Istvan | +36202345678 |

Scenario: Search for nonexisting name
	When user searches for name: "Moricz"
	Then the result should be empty

Scenario: Search for nonexisting phone number
	When user searches for phone number: "555"
	Then the result should be empty
