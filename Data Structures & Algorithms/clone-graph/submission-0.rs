/*
// Definition for a Node.
#[derive(Debug, Clone)]
pub struct Node {
    pub val: i32,
    pub neighbors: Vec<Option<Rc<RefCell<Node>>>>,
}
*/

use std::cell::RefCell;
use std::collections::HashMap;
use std::rc::Rc;

impl Solution {

    pub fn clone_graph(
        node: Option<Rc<RefCell<Node>>>
    ) -> Option<Rc<RefCell<Node>>> {

        let mut map = HashMap::new();

        Self::dfs(node, &mut map)
    }

    fn dfs(
        node: Option<Rc<RefCell<Node>>>,
        map: &mut HashMap<
            i32,
            Rc<RefCell<Node>>
        >
    ) -> Option<Rc<RefCell<Node>>> {

        let node = node?;

        let val = node.borrow().val;

        // already cloned
        if let Some(existing) = map.get(&val) {
            return Some(existing.clone());
        }

        // create clone
        let clone = Rc::new(
            RefCell::new(Node {
                val,
                neighbors: vec![],
            })
        );

        // store immediately
        map.insert(val, clone.clone());

        // clone neighbors
        for neighbor in node.borrow().neighbors.iter() {

            let cloned_neighbor =
                Self::dfs(Some(neighbor.clone()), map);

            clone
                .borrow_mut()
                .neighbors
                .push(cloned_neighbor.unwrap());
        }

        Some(clone)
    }
}