# DiffUtil Android Sample
Example of usage [DiffUtil](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html) utility class from Android Support Library 24.2.0.

## Demo
![Demo](https://github.com/mrmike/DiffUtil-sample/blob/master/raw/diffutil-sample-320.gif?raw=true)

## Implementation
[*calculateDiff*](https://developer.android.com/reference/android/support/v7/util/DiffUtil.html#calculateDiff(android.support.v7.util.DiffUtil.Callback)) method from DiffUtill class requires [DiffUtil.Callback](https://developer.android.com/reference/android/support/v7/util/DiffUtil.Callback.html) object as parameter.

### DiffUtil callback - [ActorDiffCallback.java](https://github.com/mrmike/DiffUtil-sample/blob/master/app/src/main/java/com/moczul/diffutilsample/ActorDiffCallback.java)

Implements 4 methods:
* **getOldListSize** - returns size of the old list
* **getNewListSize** - returns size of the new list
* **areItemsTheSame** - returns true if two items are the same, e.g. have the same ids 
* **areContentsTheSame** - returns true if displayed content was not changed. In our case we only display actor's name so we're detecing name's change.

### Applying diff result - [ActorAdapter.swapItems()](https://github.com/mrmike/DiffUtil-sample/blob/master/app/src/main/java/com/moczul/diffutilsample/ActorAdapter.java#L34)

DiffResult can be applied to adapter by calling **`diffResult.dispatchUpdatesTo(adapter)`**.

```
    public void swapItems(List<Actor> actors) {
        final ActorDiffCallback diffCallback = new ActorDiffCallback(this.actors, actors);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.actors.clear();
        this.actors.addAll(actors);
        diffResult.dispatchUpdatesTo(this);
    }
```
