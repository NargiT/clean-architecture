# Hexagonal Architecture

-> (French) https://www.youtube.com/watch?v=wZ7cxcU4iPE

-> just google it is an old pattern

First, one question : `Why do you want to refactor ?`

## Example

What the business wants
* firstname
* lastname
* email
* birthdate -> must be adult
* choose portfolio trading
* portfolio is in status created
* send password & login by email
* notify backoffice with the new account

What the developper wants 
* develop !
* avoid to touch legacy code (business rules are legacy ???)
* easy to test any changes
* use cool technology without breaking business rules
* do not depend from anyone
* deploy in production and take a new task

What we "see"
* Logins, Person, Portfolios, PersonPortfolios
* Save database
* send email with hermes
* broker notification with rmq
* contact secure code through JMX

### Classic way

Well 3 layer is just what all application must look like...

| Layer | Dependency
| :-------------: | :---: |
| Controller / Resource      | I |
| Services      | I |
| Dao | I |
| Entity | v |

What it really means in practice:
* business (Service) logic is highly dependant from the underlying layer (most of the time hibernate)
* often no clear line between business vs technical solution
* interfaces are underused
* TTD is hard
* less class

### Clean architecture

I don't care about architecture, I want to be able to take the decision

| Rest Controller / Database / Hermes / RMQ / JMS | Dependency |
| :-------------: | :---: |
| Port / Adapters | I |
| Use cases | I |
| Business  Domain | v |

What it really means in practice:
* One border, inside vs outside
* DEMO with the business is meaningful -> no need to wait for IT
* Dev are happy because technical layer is clearly define and can be upgrade independently
* Dev are happy because business layer is clearly define
* Tasks can be split (remember rmq... but better) thus CR are easier because only one focus
* TTD is easy and recommended + no null in business logic
* more classes