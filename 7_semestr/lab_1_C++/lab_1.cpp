#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Function to merge and sort two unsorted collections
vector<int> mergeAndSort(vector<int> collection1, vector<int> collection2) {
    // Concatenate both collections
    collection1.insert(collection1.end(), collection2.begin(), collection2.end());

    // Sort the merged collection
    sort(collection1.begin(), collection1.end());

    return collection1;
}

int main() {
    vector<int> collection1 = { 5, 1, 9, 3 };
    vector<int> collection2 = { 7, 2, 8, 4 };

    // Merge and sort the collections
    vector<int> sortedCollection = mergeAndSort(collection1, collection2);

    // Print the sorted collection
    cout << "Merged and sorted collection: ";
    for (int num : sortedCollection) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
