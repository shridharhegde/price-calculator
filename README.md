# price-calculator
Price Calculator Application gives total price of a cart in cents

## Prerequisites before running the application

- `Docker` should be installed in the local machine

## Steps to run the application

1. cd to /calculator
2. run `docker build -t calculator .`
3. Once docker build is successful run `docker run -v {local path for cart.json file}:/usr/app/cart.json -v {local path for basePrice.json file}:/usr/app/basePrice.json -t calculator:latest`