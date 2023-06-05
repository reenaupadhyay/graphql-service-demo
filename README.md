# graphql-service-demo

url: http://localhost:8080/graphiql?path=/graphql

query canbeanything {
getPets(filter: {age: 7, color: "white"}) {
  name
}
}
