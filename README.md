The task in this exercise is to provide a REST API for persisting a folder structure to a relational
database (MySQL preferred). The folder structure is provided in JSON format according to the example
below. You need to design the table structure that will store the folder tree and include SQL scripts
for initialising the database schema as part of the solution. The database structure should make it easy
to query parts of the folder structure, e.g. to query the list of files inside '/Folder_1'.</br>
Example structure:</br>
{</br>
  "name": "$ROOT$",</br>
  "files": [</br>
    {</br>
      "name": "image1.gif",</br>
      "mime_type": "image/jpeg",</br>
      "size": "13406"</br>
    },</br>
    {</br>
      "name": "image2.gif",</br>
      "mime_type": "image/gif",</br>
      "size": "3410"</br>
    }</br>
  ],</br>
  "folders": [</br>
    {</br>
      "name": "Folder_1",</br>
      "files": [</br>
        {</br>
          "name": "image3.jpg",</br>
          "mime_type": "image/jpeg",</br>
          "size": "33756"</br>
        },</br>
        {</br>
          "name": "image4.png",</br>
          "mime_type": "image/png",</br>
          "size": "10024"</br>
        }</br>
      ],</br>
      "folders": [</br>
        {</br>
          "name": "SubFolder_1",</br>
          "files": [</br>
            {</br>
              "name": "readme1.txt",</br>
              "mime_type": "text/plain",</br>
              "size": "511"</br>
            }</br>
          ]</br>
        },</br>
        {</br>
          "name": "SubFolder_2"</br>
        },</br>
        {</br>
          "name": "SubFolder_3"</br>
        }</br>
      ]</br>
    },</br>
    {</br>
      "name": "Folder_2",</br>
      "files": [</br>
        {</br>
          "name": "document1.doc",</br>
          "mime_type": "application/msword",</br>
          "size": "27301"</br>
        }</br>
      ]</br>
    }</br>
  ]</br>
}</br>
