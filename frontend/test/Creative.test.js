// Link.react.test.js
import React from 'react';
import Creative from '../src/components/Creative';
import renderer from 'react-test-renderer';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

test('Draw Creative component', () => {  
  const data = {description: 'description', header1: 'header1', header2: 'header2',  url: 'url', image: 'image'}
  const component = renderer.create(<Creative data={data} />,
  );
  let dialog = component.toJSON();
  expect(dialog).toMatchSnapshot();  
});
