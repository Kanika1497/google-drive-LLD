# Google Drive LLD

## Features
- File upload/download
- Folder structure (Composite Pattern)
- File versioning
- Sharing & permissions
- Storage abstraction (S3)

## Design Patterns
- Composite Pattern
- Strategy Pattern

## Tech
- Java
- In-memory storage

## Functional Requirements
- Upload file
- Create folder
- Delete files and folders
- download a file
- share file/folders
- view file structure
- maintain file version

## NonFunctional Requirements
- support large files
- Metadata in db
- Files stored in cloud

## Database Structure 
- User - id , name ,email , createdAt
- DriveItems - id , name , type(file or folder), parentId , ownerId , createdAt 
- FileVersion - id , url , file_id , size, createdAt 
- Permission - id , type , userid , itemid 
- ShareLinks - token ,itemId , permissiontype , expirytime