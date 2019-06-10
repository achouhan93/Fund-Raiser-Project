FROM node:10.13.0-alpine

# Load the application code in
WORKDIR /app

# Use changes to package.json to force Docker not to use the cache when we change our application nodejs dependencies:
COPY package*.json ./
RUN npm install

COPY . .

ENV PORT=8080
EXPOSE 8080
CMD ["npm" , "start"]
