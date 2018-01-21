# DiffUtil Android Sample - Kotlin
Example of usage [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html) utility class added originally in Support Library 24.2.0.

## Demo
![Demo](https://github.com/mrmike/DiffUtil-sample/blob/master/raw/diffutil-sample-320.gif?raw=true)

## Implementation
[*calculateDiff*](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html#calculateDiff(android.support.v7.util.DiffUtil.Callback)) method from DiffUtill class requires [DiffUtil.Callback](https://developer.android.com/reference/android/support/v7/util/DiffUtil.Callback.html) object as parameter.

### DiffUtil callback - [ActorDiffCallback.kt](https://github.com/mrmike/DiffUtil-sample/blob/master/app/src/main/java/com/moczul/diffutilsample/ActorDiffCallback.kt)

Implements 4 methods:
* **getOldListSize** - returns size of the old list
* **getNewListSize** - returns size of the new list
* **areItemsTheSame** - returns true if two items are the same, e.g. have the same ids 
* **areContentsTheSame** - returns true if displayed content was not changed. In our case we only display actor's name so we're detecing name's change.

### Applying diff result - [ActorAdapter.swap()](https://github.com/mrmike/DiffUtil-sample/blob/master/app/src/main/java/com/moczul/diffutilsample/ActorAdapter.kt#L31)

DiffResult can be applied to adapter by calling **`diffResult.dispatchUpdatesTo(adapter)`**.

```
    fun swap(actors: List<Actor>) {
            val diffCallback = ActorDiffCallback(this.actors, actors)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            this.actors.clear()
            this.actors.addAll(actors)
            diffResult.dispatchUpdatesTo(this)
    }
```

## Resources
* [DiffUtil @ developer.android.com](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html)
* ["DiffUtil is a must!" @ Medium](https://medium.com/@nullthemall/diffutil-is-a-must-797502bc1149#.sejum95wh)
* ["Diffing Larger Changes" @ Codepath](http://guides.codepath.com/android/using-the-recyclerview#diffing-larger-changes)

## License

    Copyright 2016 Michał Moczulski

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
