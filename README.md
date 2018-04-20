# Clean Architecture

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

What we "see"
* Logins, Person, Portfolios, PersonPortfolios
* Save database
* send email with hermes
* broker notification with rmq
* contact secure code through JMX

### Classic way

| Layer | 
| :-------------: |
| Controller / Resource      |
| Services      |
| Dao |
| Entity |

### Clean architecture

| Rest Controller / Database / Hermes / RMQ / JMS |
| :-------------: | 
| Port / Adapters |
| Use cases |
| Business        Domain |