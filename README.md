# RecyclerAdapters
## Introduction

  **RecyclerAdapters** provides you a very simple way for implement RecyclerView.Adapter class in your projects. 
  With this library you can implement Adapter in a few line.

## Get started

```java
dependencies {
    compile 'com.github.alex-michenko:recycleradapters:0.2.4'
}
```

## How to use

### 1.Create DataHolder
  Create class-wrapper that will hold data for adapter:
  ```java
  public class PersonDH extends RecyclerDH {

    public boolean isFavourite;
    public int countStars;
    public String name;

    public String headerName;

    public PersonDH(String name, boolean isFavourite) {
        this.name = name;
        this.isFavourite = isFavourite;

        if (isFavourite)
            countStars = new Random().nextInt(4) + 1;
    }

    public PersonDH(String headerName) {
        this.headerName = headerName;
    }
  }
  ```
### 2. Create ViewHolder
  Create ViewHolder class and set generic parameter as created DataHolder:
  ```java
  public class PersonVH extends RecyclerVH<PersonDH> {

    private TextView tvNamePerson;

    public PersonVH(View itemView, @Nullable final OnCardClickListener listener, final int viewType) {
        super(itemView, listener, viewType);

        tvNamePerson = findView(R.id.tvNamePerson);

        tvNamePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(view, getAdapterPosition(), viewType);
                }
            }
        });
    }

    @Override
    public void bindData(PersonDH data) {
        tvNamePerson.setText(data.name);
    }
  }
  ```
  
  If you adapter has several viewTypes then create suitable ViewHolders:
  
  ```java
  public class FavouriteVH extends RecyclerVH<PersonDH> {
    //.....
  }
  ```
  
  ```java
  public class HeaderVH extends RecyclerVH<PersonDH> {
    //.....
  }
  ```
  
### 3. Create adapter
  If all items have same viewType then you need to extend **_SimpleRecyclerAdapter_** :
  ```java
  public class ContactAdapter extends SimpleRecyclerAdapter<PersonDH, PersonVH> {

    @Override
    protected int getItemLayout() {
        return R.layout.item_person;
    }
  }
  ```
  You need to override method getItemLayout() and define layout resourse for item.
  
  For several viewTypes you need to extend **_TypedRecyclerAdapter_** :
  ```java
  public class PersonAdapter extends TypedRecyclerAdapter<PersonDH> {

    private static final int HEADER = 1;
    private static final int PERSON = 11;
    private static final int FAVOURITE = 0;

    @Override
    protected void initViewTypes() {
        addType(PERSON, R.layout.item_person, PersonVH.class);
        addType(HEADER, R.layout.item_header, HeaderVH.class);
        addType(FAVOURITE, R.layout.item_favourite, FavouriteVH.class);
    }

    @Override
    protected int getViewType(int position) {
        PersonDH dh = getItem(position);
        if (dh.headerName != null) {
            return HEADER;
        } else {
            return dh.isFavourite ? FAVOURITE : PERSON;
        }
    }
  }
  ```
  In `initViewTypes()` you need to define all viewTypes of adapter using method addType().
  
  `getViewType()` is similar `RecyclerView.Adapter#getItemViewType()`
  
### 4. Use adapter
  Init your adapter and set in _RecyclerView_ :
  ```java
        rvSimpleList = (RecyclerView) view.findViewById(R.id.rvTypedList);
        rvSimpleList.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new PersonAdapter();
        adapter.setOnCardClickListener(new OnCardClickListener() {
            @Override
            public void onClick(View view, int position, int viewType) {
                //do something
            }
        });

        rvSimpleList.setAdapter(adapter);
  ```
  
  The default `OnCardClickListener#onClick()` is called when clicked on item. You may define in ViewHolder other calls of method.
  
  *For more information see sample.*
  
## License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
