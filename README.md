<img src="https://c.tenor.com/ocbSyB0zW58AAAAC/tenor.gif">


# SonataMarketPlace

SonataMarketPlace - backend приложение, которое имеет функционал для взаимодействия с БД. Основная задача этого приложение - возможность взаимодействовать с БД и управлять данными в ней.

## В этом приложении использовались:

- Java

- PostgreSQL

- Spring Framework

- Maven

## PostgreSQL

в application.properties нужно будет указать свои данные:

- url

* username(default = postgres)

+ password(default = postgres)
```
spring.datasource.url=jdbc:postgresql://localhost:5432/sonata
spring.datasource.username=username
spring.datasource.password=password
```

## API

### Get запрос
localhost:8092/clothes
```JSON
[
    {
        "id": 1,
        "type": "jacket",
        "name": "heaven above",
        "size": "M",
        "price": 5000,
        "quantity": 100,
        "description": "крутая куртка"
    },
    {
        "id": 34,
        "type": "jersey",
        "name": "heaven above",
        "size": "M",
        "price": 3500,
        "quantity": 100,
        "description": "имба джерси, у меня такой"
    },
    {
        "id": 35,
        "type": "sweater",
        "name": "heaven above",
        "size": "M",
        "price": 6000,
        "quantity": 100,
        "description": "Свитер с рукавами до пола"
    }
]
```
localhost:8092/clothes/{id}
```JSON
{
    "id": 1,
    "type": "jacket",
    "name": "heaven above",
    "size": "M",
    "price": 5000,
    "quantity": 100,
    "description": "крутая куртка"
}
```
### Post запрос

localhost:8092/clothes

```JSON
{
    "type": "sweater",
    "name": "heaven above",
    "size": "M",
    "price": 6000,
    "quantity": 100,
    "description": "Свитер с рукавами до пола"
}
```
> [!IMPORTANT]
> price и quantity не могут быть меньше 0.

> [!IMPORTANT]
> ID заполняется автоматически.

### Put запрос

localhost:8092/clothes{id}

```JSON
{
    "type": "jersey",
    "name": "Gothic",
    "size": "M",
    "price": 3500,
    "quantity": 100,
    "description": "имба а не джерси"
}
```
### Delete запрос

localhost:8092/clothes{id}

Хз че тут писать

<img src="https://c.tenor.com/72ScVNgTGpYAAAAC/tenor.gif">
