FROM node:10.13.0-alpine
# Load the application code in
WORKDIR /app
COPY . .
RUN npm install
EXPOSE 8080
CMD ["npm", "start"]
