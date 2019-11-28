var demoData = [
    { id: 1, name: 'Test1', email: 'test1@test.com', choose: 'First' },
    { id: 2, name: 'Test2', email: 'test2@test.com', choose: 'Second' },
    { id: 3, name: 'Test3', email: 'test3@test.com', choose: 'First' },
    { id: 4, name: 'Test4', email: 'test4@test.com', choose: 'Third' },
  ];

export function getItems(nameService) {
    return demoData
}

export function editItem(nameService,itemId,item) {
    var index=0;
    demoData.forEach(element => {
        if (itemId === element.id){
            var tempArray=demoData.slice();
            tempArray[index] = item;
            demoData = tempArray;
        } 
        index++;
    });
    return demoData;
}

export function createItem(nameService,item) {
    demoData.push(item);
    return demoData;
}

export function deleteItem(nameService,itemId) {
    var index=0;
    demoData.forEach(element => {
        if (itemId === element.id){
            demoData.splice(index, 1);
        } 
        index++;
    });
    return demoData;
}

