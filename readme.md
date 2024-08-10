# SpringBoot-Library 图书租赁管理系统 后端
## 首先在pom.xml来运行添加依赖
## 选择LibraryApplication然后即可运行

## 测试方法：
### books
 纯后端情况下，打开postman
 http://localhost:8080/api/books
- post:
- `body->raw->json`

举个例子：
```json
{
"title": "Effective Java",
"author": "Joshua Bloch"
}
```
之后send
- delete
  http://localhost:8080/api/books/1

之后send
- 其它类似


### rental:
操作方法类似
json：
```json
{
    "book": {
        "id": 1
    },
    "startDate": "2024-08-10",
    "endDate": "2024-08-15"
}
```