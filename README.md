The task in this exercise is to provide a REST API for persisting a folder structure to a relational
database (MySQL preferred). The folder structure is provided in JSON format according to the example
below. You need to design the table structure that will store the folder tree and include SQL scripts
for initialising the database schema as part of the solution. The database structure should make it easy
to query parts of the folder structure, e.g. to query the list of files inside '/Folder_1'.

Example structure:
{
  "name": "$ROOT$",
  "files": [
    {
      "name": "image1.gif",
      "mime_type": "image/jpeg",
      "size": "13406"
    },
    {
      "name": "image2.gif",
      "mime_type": "image/gif",
      "size": "3410"
    }
  ],
  "folders": [
    {
      "name": "Folder_1",
      "files": [
        {
          "name": "image3.jpg",
          "mime_type": "image/jpeg",
          "size": "33756"
        },
        {
          "name": "image4.png",
          "mime_type": "image/png",
          "size": "10024"
        }
      ],
      "folders": [
        {
          "name": "SubFolder_1",
          "files": [
            {
              "name": "readme1.txt",
              "mime_type": "text/plain",
              "size": "511"
            }
          ]
        },
        {
          "name": "SubFolder_2"
        },
        {
          "name": "SubFolder_3"
        }
      ]
    },
    {
      "name": "Folder_2",
      "files": [
        {
          "name": "document1.doc",
          "mime_type": "application/msword",
          "size": "27301"
        }
      ]
    }
  ]
}